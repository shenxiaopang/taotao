package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * 商品管理接口
 */
public interface ItemCatService {

    List<EasyUITreeNode> getItemCatList(Long parentId);
}
