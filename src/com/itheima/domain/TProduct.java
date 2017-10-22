package com.itheima.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * @Date 2017/10/19 19:58
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: com.itheima.domain
 * @ClassName: TProduct
 * @Description:
 *
 */
@Entity
@Table(name = "product", schema = "shop", catalog = "")
public class TProduct {
    private String pid;
    private String pname;
    private Double marketPrice;
    private Double shopPrice;
    private String pimage;
    private Date pdate;
    private Integer isHot;
    private String pdesc;
    private Integer pflag;
    private String cid;
    private Collection<TOrderitem> orderitemsByPid;
    private TCategory categoryByCid;

    @Id
    @Column(name = "pid", nullable = false, length = 100)
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "pname", nullable = true, length = 50)
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Basic
    @Column(name = "market_price", nullable = true, precision = 0)
    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    @Basic
    @Column(name = "shop_price", nullable = true, precision = 0)
    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    @Basic
    @Column(name = "pimage", nullable = true, length = 200)
    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    @Basic
    @Column(name = "pdate", nullable = true)
    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    @Basic
    @Column(name = "is_hot", nullable = true)
    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    @Basic
    @Column(name = "pdesc", nullable = true, length = 255)
    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    @Basic
    @Column(name = "pflag", nullable = true)
    public Integer getPflag() {
        return pflag;
    }

    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    @Basic
    @Column(name = "cid", nullable = true, length = 100 )
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TProduct tProduct = (TProduct) o;

        if (pid != null ? !pid.equals(tProduct.pid) : tProduct.pid != null) return false;
        if (pname != null ? !pname.equals(tProduct.pname) : tProduct.pname != null) return false;
        if (marketPrice != null ? !marketPrice.equals(tProduct.marketPrice) : tProduct.marketPrice != null)
            return false;
        if (shopPrice != null ? !shopPrice.equals(tProduct.shopPrice) : tProduct.shopPrice != null) return false;
        if (pimage != null ? !pimage.equals(tProduct.pimage) : tProduct.pimage != null) return false;
        if (pdate != null ? !pdate.equals(tProduct.pdate) : tProduct.pdate != null) return false;
        if (isHot != null ? !isHot.equals(tProduct.isHot) : tProduct.isHot != null) return false;
        if (pdesc != null ? !pdesc.equals(tProduct.pdesc) : tProduct.pdesc != null) return false;
        if (pflag != null ? !pflag.equals(tProduct.pflag) : tProduct.pflag != null) return false;
        if (cid != null ? !cid.equals(tProduct.cid) : tProduct.cid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pid != null ? pid.hashCode() : 0;
        result = 31 * result + (pname != null ? pname.hashCode() : 0);
        result = 31 * result + (marketPrice != null ? marketPrice.hashCode() : 0);
        result = 31 * result + (shopPrice != null ? shopPrice.hashCode() : 0);
        result = 31 * result + (pimage != null ? pimage.hashCode() : 0);
        result = 31 * result + (pdate != null ? pdate.hashCode() : 0);
        result = 31 * result + (isHot != null ? isHot.hashCode() : 0);
        result = 31 * result + (pdesc != null ? pdesc.hashCode() : 0);
        result = 31 * result + (pflag != null ? pflag.hashCode() : 0);
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productByPid")
    public Collection<TOrderitem> getOrderitemsByPid() {
        return orderitemsByPid;
    }

    public void setOrderitemsByPid(Collection<TOrderitem> orderitemsByPid) {
        this.orderitemsByPid = orderitemsByPid;
    }

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    public TCategory getCategoryByCid() {
        return categoryByCid;
    }

    public void setCategoryByCid(TCategory categoryByCid) {
        this.categoryByCid = categoryByCid;
    }
}
