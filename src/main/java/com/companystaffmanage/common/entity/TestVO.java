package com.companystaffmanage.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wsHawk
 * @Title: TestVO
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @since 2020/11/8 13:45
 */
@Data
public class TestVO extends TestUser implements Serializable {
    private static final long serialVersionUID = -5992579999087844630L;

    private List<TestUser> list;
}
