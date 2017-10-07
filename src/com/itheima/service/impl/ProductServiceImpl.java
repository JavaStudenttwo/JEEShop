package com.itheima.service.impl;

import com.itheima.dao.ProductDao;
import com.itheima.dao.impl.ProductDaoImpl;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;

import java.sql.SQLException;
import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-8-30
 * discription:商品业务处理
 * indetail:
 *
 */
public class ProductServiceImpl implements ProductService {

    ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> findProductByword(String word) throws SQLException {

        /*StringBuilder builder = new StringBuilder();
        List<Object> paramList = new ArrayList<Object>();

        if(word != null){
            StringBuilder wordBuilder = new StringBuilder();
            wordBuilder.append("%");
            for (int i=0 ;i<word.length() ;i++){
                wordBuilder.append(word.charAt(i)).append("%");
            }
            builder.append(" and pname like ?");
            paramList.add(wordBuilder.toString());

            builder.append(" or pinyin like ?");
            paramList.add(wordBuilder.toString());
        }

        String condition = builder.toString();
        Object[] params = paramList.toArray();

        ProductDao productDao = new ProductDaoImpl();
        return productDao.findProductByword(condition,params);*/

        return productDao.findProductByword(word);



    }

    @Override
    public List<Product> findByHOt() throws SQLException {
        List<Product> list = productDao.findByHot();
        return list;
    }

    @Override
    public List<Product> findByNew() throws SQLException {
        List<Product> list = productDao.findByNew();
        return list;
    }

    @Override
    public Product findById(String pid) throws SQLException {
        Product product = productDao.findById(pid);
        return product;
    }

    /**
     * creater:litiecheng
     * createDate:2017-9-8
     * discription:分页查询某一分类的商品
     * indetail:
     *
     * @parameter：1.分类标记(cid)，2.当前页页码，3.每页显示总数
     * @return：pageBean对象
     *
     */
    @Override
    public PageBean<Product> findByCid(String cid, int pageNumber, int pageSize) throws SQLException {
        /**1.先差查询此类别的商品的总数*/
        int totalRecord = productDao.findTotalRecordByCid(cid);
        /**2.分页查询*/
        PageBean<Product> pageBean = new PageBean<Product>(pageNumber,pageSize,totalRecord);

        List<Product> data = productDao.findAllByCid(cid,pageBean.getStartIndex(),pageBean.getPageSize());

        pageBean.setData(data);

        return pageBean;

    }

    @Override
    public PageBean<Product> findAll(int pageNumber, int pageSize) throws SQLException {

        int totalRecord = productDao.findTotalRecord();

        PageBean<Product> pageBean = new PageBean<Product>(pageNumber,pageSize,totalRecord);

        List<Product> data = productDao.findAll(pageBean.getStartIndex(),pageBean.getPageSize());

        pageBean.setData(data);

        return pageBean;
    }

    @Override
    public int productDelete(String pid) throws SQLException {
        return productDao.productDelete(pid);
    }
}
