package com.ssm.common.enums;

/**
 * 操作结果前端消息提示
 */
public enum MsgStateEnum {
    /**调试*/
	DEBUG("-1"),
    /**失败*/
    ERROR("0"),
    /**成功*/
    SUCCESS("1"),
    /**警告*/
    WARNING("2"),
    /**异常*/
    EXCEPTION("3"),
    /**待确认*/
    CONFIRM("4");

	private final String value;

	MsgStateEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
