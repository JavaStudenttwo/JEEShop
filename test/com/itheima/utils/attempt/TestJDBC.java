package com.itheima.utils.attempt;

import org.junit.Test;

import java.sql.*;

public class TestJDBC {

    @Test
    public void addData_account() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        Class.forName("com.mysql.jdbc.Driver");


        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shop", "root", "123");

        Statement statement = connection.createStatement();

        String sql1 = "INSERT INTO selleraccount (name,money) VALUES ('BOCO-NET-B2C',10000)";

        String sql2 = "UPDATE selleraccount set name = 'ICBC-NET-B2C' WHERE id = 2 ";
        boolean b = statement.execute(sql1);
        int i = statement.getUpdateCount();
        System.out.println(b+"   "+i);

        statement.close();
        connection.close();
    }

    /*<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked" />工商银行
            <img src="${pageContext.request.contextPath}/bank_img/icbc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="pd_FrpId" value="BOC-NET-B2C" />中国银行
            <img src="${pageContext.request.contextPath}/bank_img/bc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="pd_FrpId" value="ABC-NET-B2C" />农业银行
            <img src="${pageContext.request.contextPath}/bank_img/abc.bmp" align="middle" />
						<br/><br/>
						<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C" />交通银行
            <img src="${pageContext.request.contextPath}/bank_img/bcc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="pd_FrpId" value="PINGANBANK-NET" />平安银行
            <img src="${pageContext.request.contextPath}/bank_img/pingan.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="pd_FrpId" value="CCB-NET-B2C" />建设银行
            <img src="${pageContext.request.contextPath}/bank_img/ccb.bmp" align="middle" />
						<br/><br/>
						<input type="radio" name="pd_FrpId" value="CEB-NET-B2C" />光大银行
            <img src="${pageContext.request.contextPath}/bank_img/guangda.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C" />招商银行
            <img src="${pageContext.request.contextPath}/bank_img/cmb.bmp" align="middle" />*/


}
