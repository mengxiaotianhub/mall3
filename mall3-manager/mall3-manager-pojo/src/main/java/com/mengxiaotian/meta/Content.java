package com.mengxiaotian.meta;

import javax.persistence.*;

@Table(name = "content")
public class Content {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 当前价格
     */
    private Integer price;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片连接
     */
    private String image;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 正文
     */
    private byte[] detail;

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
     * 获取当前价格
     *
     * @return price - 当前价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置当前价格
     *
     * @param price 当前价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取图片连接
     *
     * @return image - 图片连接
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置图片连接
     *
     * @param image 图片连接
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取摘要
     *
     * @return summary - 摘要
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置摘要
     *
     * @param summary 摘要
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 获取正文
     *
     * @return detail - 正文
     */
    public byte[] getDetail() {
        return detail;
    }

    /**
     * 设置正文
     *
     * @param detail 正文
     */
    public void setDetail(byte[] detail) {
        this.detail = detail;
    }
   
    @Transient
    private boolean isBuy;
    @Transient
    private boolean isSell;

	public boolean isBuy() {
		return isBuy;
	}

	public void setBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}

	public boolean isSell() {
		return isSell;
	}

	public void setSell(boolean isSell) {
		this.isSell = isSell;
	}
    
}