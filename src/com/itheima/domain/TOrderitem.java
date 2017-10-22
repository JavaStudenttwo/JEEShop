package com.itheima.domain;

import javax.persistence.*;

/**
 * @Date 2017/10/19 19:58
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: com.itheima.domain
 * @ClassName: TOrderitem
 * @Description:
 *
 */
@Entity
@Table(name = "orderitem", schema = "shop", catalog = "")
public class TOrderitem {
    private String itemid;
    private Integer count;
    private Double subtotal;
    private String pid;
    private String oid;
    private TProduct productByPid;
    private TOrders ordersByOid;

    @Id
    @Column(name = "itemid", nullable = false, length = 100)
    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    @Basic
    @Column(name = "count", nullable = true)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "subtotal", nullable = true, precision = 0)
    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Basic
    @Column(name = "pid", nullable = true, length = 100)
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "oid", nullable = true, length = 100)
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TOrderitem that = (TOrderitem) o;

        if (itemid != null ? !itemid.equals(that.itemid) : that.itemid != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (subtotal != null ? !subtotal.equals(that.subtotal) : that.subtotal != null) return false;
        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        if (oid != null ? !oid.equals(that.oid) : that.oid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemid != null ? itemid.hashCode() : 0;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (subtotal != null ? subtotal.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (oid != null ? oid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "pid")
    public TProduct getProductByPid() {
        return productByPid;
    }

    public void setProductByPid(TProduct productByPid) {
        this.productByPid = productByPid;
    }

    @ManyToOne
    @JoinColumn(name = "oid", referencedColumnName = "oid")
    public TOrders getOrdersByOid() {
        return ordersByOid;
    }

    public void setOrdersByOid(TOrders ordersByOid) {
        this.ordersByOid = ordersByOid;
    }
}
