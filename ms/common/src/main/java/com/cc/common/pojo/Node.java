package com.cc.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 通过此对象封装一些树(Tree)节点(Node)信息，
 设计 Node 类型，基于此对象存储树节点信息
 <p>on 2021/3/22 11:19
 */
@Data
public class Node implements Serializable {
    private static final long serialVersionUID = 9110110344532785412L;
    private Integer id;
    private String name;
    private Integer parentId;
}
