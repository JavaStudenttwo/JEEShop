package com.itheima.domain;

import javax.persistence.*;

/**
 * @Date 2017/10/19 20:00
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: com.itheima.domain
 * @ClassName: TSelleraccount
 * @Description:
 *
 */
@Entity
@Table(name = "selleraccount", schema = "shop", catalog = "")
public class TSelleraccount {
    private int id;
    private String name;
    private Integer money;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "money", nullable = true)
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TSelleraccount that = (TSelleraccount) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        return result;
    }
}
