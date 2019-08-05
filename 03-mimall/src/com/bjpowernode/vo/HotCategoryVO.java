package com.bjpowernode.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bjpowernode.po.OsCategory;
import com.bjpowernode.po.OsProduct;

public class HotCategoryVO {
	
	private String name;
	private ArrayList<CategoryVO> childrenCategorys;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<CategoryVO> getChildrenCategorys() {
		return childrenCategorys;
	}
	public void setChildrenCategorys(ArrayList<CategoryVO> childrenCategorys) {
		this.childrenCategorys = childrenCategorys;
	}
}
