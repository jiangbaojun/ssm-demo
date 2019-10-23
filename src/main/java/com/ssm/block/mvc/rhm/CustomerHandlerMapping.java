package com.ssm.block.mvc.rhm;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 自定义RequestMappingHandlerMapping类型。通过<mvc:annotation-driven>注册,注意声明该bean的order为0，<property name="order" value="0"/>
 */
public class CustomerHandlerMapping extends RequestMappingHandlerMapping {

	/**
	 * 发现方法上的@RequestMapping注解，生成condition
	 * 自定义方法condition
	 */
	@Override
	protected RequestCondition<?> getCustomMethodCondition(Method method) {
		RequestMapping classRequestMapping = method.getAnnotation(RequestMapping.class);
		if (classRequestMapping == null) {
			return super.getCustomMethodCondition(method);
		}
		WhereFrom template = method.getAnnotation(WhereFrom.class);
		if (template == null || template.value() == null) {
			return super.getCustomMethodCondition(method);
		}
		return new CustomerRequestCondition(template.value(),template.order());
	}

	/**
	 * 发现类上的@RequestMapping注解，生成condition
	 * 自定义类condition
	 */
	@Override
	protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
		RequestMapping classRequestMapping = handlerType.getAnnotation(RequestMapping.class);
		if (classRequestMapping == null) {
			return super.getCustomTypeCondition(handlerType);
		}
		WhereFrom template = handlerType.getAnnotation(WhereFrom.class);
		if (template == null || template.value() == null) {
			return super.getCustomTypeCondition(handlerType);
		}
		return new CustomerRequestCondition(template.value(),template.order());
	}

	/**
	 * 使用方法和类上面的RequestMapping注解，生成一个RequestMappingInfo
	 * 没有特殊情况，不建议扩展
	 */
	@Override
	protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
		/*************** 父级getMappingForMethod是通过1和2两个步骤实现 *******************/
		// 1）从方法中读取 RequestMapping 信息并创建 RequestMappingInfo
		RequestMappingInfo info = createRequestMappingInfo(method);
		if (info != null) {
			// 2）从处类中读取 RequestMapping 信息并创建 RequestMappingInfo
			RequestMappingInfo typeInfo = createRequestMappingInfo(handlerType);
			if (typeInfo != null) {
				// 如果存在，则合并
				info = typeInfo.combine(info);
			}
			// 3）1和2上面两步骤是默认的方式，类上面声明的路径加上方法上声明的路径。此步骤仅为测试，给所有映射加一个前缀"t1"，并且把类上面的路径拼上一个"test_"前缀
//			String typePath = getPath(handlerType);
//			if (typePath != null) {
//				info = RequestMappingInfo.paths("t1/"+"test_"+typePath).build().combine(info);
//			}
		}
		return info;
	}

	@SuppressWarnings("unused")
	private String getPath(Class<?> handlerType) {
		RequestMapping classRequestMapping = handlerType.getAnnotation(RequestMapping.class);
		if (classRequestMapping == null) {
			return null;
		}
		StringBuilder mappingUrlBuilder = new StringBuilder();
		if (classRequestMapping.value().length > 0) {
			mappingUrlBuilder.append(classRequestMapping.value()[0]);
		}
		String mappingUrl = mappingUrlBuilder.toString();
		return mappingUrl;
	}

	private RequestMappingInfo createRequestMappingInfo(AnnotatedElement element) {
		// 读取注解元素上的 RequestMapping 注解信息
		RequestMapping requestMapping = AnnotatedElementUtils.findMergedAnnotation(element, RequestMapping.class);
		if (requestMapping == null) {
			return null;
		}

		/**
		 * 1）如果是 class，则通过 getCustomTypeCondition 读取 RequestCondition 2）如果是 method，则通过
		 * getCustomMethodCondition 读取 RequestCondition 特性未实现，都返回 null
		 */
		RequestCondition<?> condition = (element instanceof Class ? getCustomTypeCondition((Class<?>) element)
				: getCustomMethodCondition((Method) element));
		/**
		 * 2）构建新的RequestMapping，实际上是对@RequestMapping注解的包装和修改
		 */
		RequestMapping newRequestMapping = new RequestMapping() {
			@Override
			public Class<? extends Annotation> annotationType() {
				return RequestMapping.class;
			}
			
			@Override
			public String[] value() {
				return requestMapping.value();
			}
			
			@Override
			public String[] produces() {
				return requestMapping.produces();
			}
			
			@Override
			public String[] path() {
				return requestMapping.path();
			}
			
			@Override
			public String[] params() {
				return requestMapping.params();
			}
			
			@Override
			public String name() {
				return requestMapping.name();
			}
			
			@Override
			public RequestMethod[] method() {
				return requestMapping.method();
//				return new RequestMethod[] {RequestMethod.POST};
			}
			
			@Override
			public String[] headers() {
				return requestMapping.headers();
			}
			
			@Override
			public String[] consumes() {
				return requestMapping.consumes();
			}
		};
		return createRequestMappingInfo(newRequestMapping, condition);
	}
}