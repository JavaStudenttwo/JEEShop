package com.itheima.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * @Date 2017/10/19 19:58
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: com.itheima.domain
 * @ClassName: TOrders
 * @Description:
 *
 */
@Entity
@Table(name = "orders", schema = "shop", catalog = "")
public class TOrders {
    private String oid;
    private Timestamp ordertime;
    private Double total;
    private Integer state;
    private String address;
    private String name;
    private String telephone;
    private String uid;
    private Collection<TOrderitem> orderitemsByOid;

    @Id
    @Column(name = "oid", nullable = false, length = 100)
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "ordertime", nullable = true)
    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    @Basic
    @Column(name = "total", nullable = true, precision = 0)
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Basic
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 30)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "telephone", nullable = true, length = 20)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "uid", nullable = true, length = 100)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TOrders tOrders = (TOrders) o;

        if (oid != null ? !oid.equals(tOrders.oid) : tOrders.oid != null) return false;
        if (ordertime != null ? !ordertime.equals(tOrders.ordertime) : tOrders.ordertime != null) return false;
        if (total != null ? !total.equals(tOrders.total) : tOrders.total != null) return false;
        if (state != null ? !state.equals(tOrders.state) : tOrders.state != null) return false;
        if (address != null ? !address.equals(tOrders.address) : tOrders.address != null) return false;
        if (name != null ? !name.equals(tOrders.name) : tOrders.name != null) return false;
        if (telephone != null ? !telephone.equals(tOrders.telephone) : tOrders.telephone != null) return false;
        if (uid != null ? !uid.equals(tOrders.uid) : tOrders.uid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid != null ? oid.hashCode() : 0;
        result = 31 * result + (ordertime != null ? ordertime.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ordersByOid")
    public Collection<TOrderitem> getOrderitemsByOid() {
        return orderitemsByOid;
    }

    public void setOrderitemsByOid(Collection<TOrderitem> orderitemsByOid) {
        this.orderitemsByOid = orderitemsByOid;
    }
}
