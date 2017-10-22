package com.itheima.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * @Date 2017/10/19 19:58
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: com.itheima.domain
 * @ClassName: TCategory
 * @Description:
 *
 */
@Entity
@Table(name = "category", schema = "shop", catalog = "")
public class TCategory {
    private String cid;
    private String cname;
    private Collection<TProduct> productsByCid;

    @Id
    @Column(name = "cid", nullable = false, length = 100)
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "cname", nullable = true, length = 20)
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TCategory tCategory = (TCategory) o;

        if (cid != null ? !cid.equals(tCategory.cid) : tCategory.cid != null) return false;
        if (cname != null ? !cname.equals(tCategory.cname) : tCategory.cname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoryByCid")
    public Collection<TProduct> getProductsByCid() {
        return productsByCid;
    }

    public void setProductsByCid(Collection<TProduct> productsByCid) {
        this.productsByCid = productsByCid;
    }
}
