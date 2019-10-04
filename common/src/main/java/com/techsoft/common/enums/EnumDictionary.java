package com.techsoft.common.enums;
/**
 * 
 * @author tanyekai
 *  
 */
public enum EnumDictionary {
	SYSTEM_TYPE(1020L),//系统类型
	DATA_TABLE(1021L),//数据表
	BILL_TYPE(1022L),//单据类型
	BILL_STATUS(1023L),//单据状态
	FIRM_PARTNER_TYPE(1024L),//合作公司类型
	STRUCT_FACTORY_TYPE(1025L),//工厂类型
	STRUCT_WAREHOUSE_TYPE(1026L),//仓库类型
	STRUCT_PROCESS(1027L),//制程
	STRUCT_WORKGROUP(1028L),//工作组
	STRUCT_PROCEDUER_INSTUCT_TYPE(1029L),//工序指令类型
	CONFIG_BARCODE_RULE(1030L),///条码规则类型
	CONFIG_BARCODE_PRINT_MODE(1031L),//条码打印方式
	CONFIG_BARCODE_RESETMODE(1032L),//复位方式
	PRODUCT_MATERIAL_STATUS(1033L),//物料状态
	PRODUCT_TYPE(1035L),//物品类型
	PRODUCT_STATUS(1036L),//物品状态
	PRODUCT_SOURCE(1037L),//物品来源
	PRODUCT_CLASSES_UNIT(1038L),//物品分类单位
	PRODUCT_BOM_STATUS(1039L),//产品BOM状态1042
	PACKBOX_STATUS_DICT(1040L),//包装箱状态
	QUALITY_INSPECT_MODE(1041L), //IQC检验方式
	BILL_STATUS_WORKORDER(1042L), //工单状态
	CONFIG_LABEL_FUNCTION(1051L),//标签功能定义类型
	EMPLOYEE_STATUS(1052L),//员工状态
	ALARM_TYPE(1053L),//报警类型
	ALARM_GROUP(1054L),//报警群组
	FIXTURE_TYPE(1055L),//工具类型
	FIXTURE_STATUS(1056L),//工具状态
	BILL_TYPE_FIXTURE(1057L),//工具单据类型
	BILL_STATUS_FIXTURE(1058L),//工具单据状态
	FIXTURE_TCORRECT_TYPE(1059L),//校正管控类型
	FIXTURE_SCRAP_TYPE(1060L),//报废管控类型
	ALARM_STATUS(1061L),//报警状态
	WAREHOUSE_PALLET_STATUS(1062L),//栈板状态
	BILL_STATUS_INSPECT(1063L),//检验单状态
	QUALITY_INSPECT_RESULT(1064L),//检验结果
	QUALITY_INSPECT_DEAL_RESULT(1065L),//检验处理结果 
	QUALITY_INSPECT_ITEM_TYPE(1066L),//检验项类型
	QUALITY_SAMPLE_LEVEL(1067L),//检验水平  
	BARCODE_OPERATION_STATUS(1068L),//条码操作状态
	BARCODE_STATUS(1069L),//条码状态
	QUALITY_INSPECT_TYPE_QC(1070L),//检验QC类型
	PROCESS_EXECUTIVE_TYPE(1071L),//流程执行方类型
	PROCESS_LINE_TYPE(1072L),//流程流转线类型
	WORKORDER_WHICHSIDE(1073L),//派工单正反面
	QUALITY_SAMPLE_LEVEL_RANK(1074L),//检验水平级别
	WAREHOURE_LOCATION_TYPE(1076L),//库位类型
	PACKBOX_MEASURE_TYPE(1077L),//包装度量单位
	DOWNSHELF_ATTRIBUTE(1078L),//下架策略属性
	DOWNSHELF_ATTRIBUTE_ADCDES_ORDER(1079L),//下架属性升序/降序
	DOWNSHELF_MODE_MATCHING(1080L),//下架匹配方式
 
	WAREHOUSE_INVENTORY_MODE(1082L),//盘点方式
	WORK_TASK_STATUS(1083L),//生产任务状态
	WORK_PLAN_STATUS(1084L),//生产计划状态
	AUDIT_STATUS(1085L),//审核状态
	SETTLE_STATUS(1086L),//盈亏结算状态
	SEMI_PRODUCT_TYPE(1087L),//半成品类型
	ERP_PRODUCT_TYPE(1088L),//ERP物品类型
	ALARM_DEAL_RESULT(1089L),//安灯信息处理结果(设备报警处理结果)
	CONFIG_INTERFACE_TYPE(1090L),//接口类型
	CONFIG_INTERFACE_CALLER(1091L),//接口方类型
	EQUIP_SWITCH_STATUS(1092L),//设备开关状态
	BILL_TYPE_EQUIP(1093L),//设备单据类型
	BILL_STATUS_EQUIP(1094L),//设备单据状态
	BILL_ITEM_DEAL_RESULT(1095L),//单据明细处理状态
	; 
	
	private Long value;

	private EnumDictionary(Long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}
}
