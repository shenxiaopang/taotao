package com.taotao.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<EasyUITreeNode> getItemCatList(Long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);
        List<EasyUITreeNode> easyUITreeNodeList = new ArrayList<>();
        for (TbItemCat item :tbItemCats ) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(item.getId());
            /*如果是父節點，就不要展开节点*/
            node.setState(item.getIsParent()?"closed":"open");
            node.setText(item.getName());
            easyUITreeNodeList.add(node);
        }
        return easyUITreeNodeList;
    }
}
