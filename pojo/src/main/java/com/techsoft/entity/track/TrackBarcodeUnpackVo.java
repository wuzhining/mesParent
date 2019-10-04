package com.techsoft.entity.track;

import com.techsoft.entity.common.BarcodeMain;
import com.techsoft.entity.common.StructFactory;
import com.techsoft.entity.common.TrackBarcodeUnpack;
import com.techsoft.entity.common.UserPassport;

public class TrackBarcodeUnpackVo extends TrackBarcodeUnpack{
	/**
	*@auther:Wang
	*@version:2019年4月30日上午11:33:56
	*@description
	*/
	private static final long serialVersionUID = -5050786529743597399L;
	private UserPassport userPassportList; //操作人
	private StructFactory structFactorylist;//工厂名称
	private BarcodeMain barcodeMainlist;//条码
	public TrackBarcodeUnpackVo(){
		
	}
	public TrackBarcodeUnpackVo(TrackBarcodeUnpack value) {
		value.cloneProperties(this);
	}
	public UserPassport getUserPassportList() {
		return userPassportList;
	}
	public void setUserPassportList(UserPassport userPassportList) {
		this.userPassportList = userPassportList;
	}
	public StructFactory getStructFactorylist() {
		return structFactorylist;
	}
	public void setStructFactorylist(StructFactory structFactorylist) {
		this.structFactorylist = structFactorylist;
	}
	public BarcodeMain getBarcodeMainlist() {
		return barcodeMainlist;
	}
	public void setBarcodeMainlist(BarcodeMain barcodeMainlist) {
		this.barcodeMainlist = barcodeMainlist;
	}
	
}
