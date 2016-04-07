package com.mengxiaotian.meta;

import javax.persistence.*;

@Table(name = "trx")
public class Trx {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 内容ID
     */
    @Column(name = "contentId")
    private Integer contentId;

    /**
     * 用户ID
     */
    @Column(name = "personId")
    private Integer personId;

    /**
     * 购买价格
     */
    @Column(name = "buyPrice")
    private Integer buyPrice;

    /**
     * 购买时间
     */
    @Column(name = "buyTime")
    private Long buyTime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取内容ID
     *
     * @return contentId - 内容ID
     */
    public Integer getContentId() {
        return contentId;
    }

    /**
     * 设置内容ID
     *
     * @param contentid 内容ID
     */
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    /**
     * 获取用户ID
     *
     * @return personId - 用户ID
     */
    public Integer getPersonId() {
        return personId;
    }

    /**
     * 设置用户ID
     *
     * @param personid 用户ID
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /**
     * 获取购买价格
     *
     * @return buyPrice - 购买价格
     */
    public Integer getBuyPrice() {
        return buyPrice;
    }

    /**
     * 设置购买价格
     *
     * @param buyprice 购买价格
     */
    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * 获取购买时间
     *
     * @return buyTime - 购买时间
     */
    public Long getBuyTime() {
        return buyTime;
    }

    /**
     * 设置购买时间
     *
     * @param buytime 购买时间
     */
    public void setBuyTime(Long buyTime) {
        this.buyTime = buyTime;
    }
}