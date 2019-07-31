package de.bib.spring.simple.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import de.bib.spring.simple.jdbc.model.Product;
import de.bib.spring.simple.jdbc.util.LoggerApp;

/**
 * Class handle connection model product to database .
 * 
 * @author User
 *
 */
public class ProductDao {

	private Logger log = Logger.getLogger(ProductDao.class.getName());

	private static final String SQL_INSERT_PRODUCT = "insert into Product (Kode_Product,Nama_Product,Desc_Product,Unit_Product,Harga_Product) values (?,?,?,?,?)";
	private static final String SQL_GET_PRODUCT_BYID = "select * from Product where Kode_Product = ?";
	private static final String SQL_DELETE_PRODUCT_BYID = "delete from Product where Kode_Product = ?";

	private DataSource dataSource;

	/**
	 * Constructor without connection parameter.
	 * 
	 * @param conn
	 */
	public ProductDao(DataSource dtSource) {
		this.dataSource = dtSource;

	}
	
	public ProductDao() {
		
	}

	/**
	 * Get DataSource
	 * 
	 * @return
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * Set DataSources
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dtSource) {
		this.dataSource = dtSource;
	}

	/**
	 * Handle insert product to database.
	 * 
	 * @param p
	 * @throws SQLException
	 */
	public void simpan(Product p) throws SQLException {
		Connection c = dataSource.getConnection();

		try {
			c.setAutoCommit(false);
			PreparedStatement ps = c.prepareStatement(SQL_INSERT_PRODUCT);
			ps.setInt(1, p.getKodeProduct());
			ps.setString(2, p.getNameProduct());
			ps.setString(3, p.getDescProduct());
			ps.setString(4, p.getUnitProduct());
			ps.setBigDecimal(5, p.getHargaProduct());

			ps.executeUpdate();
			c.commit();

		} catch (Exception e) {
			c.rollback();
			log.error("Error, when insert product to database, cause :" + LoggerApp.printLog(e));
		} finally {
			if (c != null) {
				c.close();
			}
		}
	}

	/**
	 * Get product by kode_product
	 * 
	 * @param id kode product
	 * @return
	 * @throws SQLException
	 */
	public Product cariById(Integer id) throws SQLException {
		Product p = new Product();
		Connection c = dataSource.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			c.setAutoCommit(false);
			ps = c.prepareStatement(SQL_GET_PRODUCT_BYID);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			c.commit();

			while (rs.next()) {
				p.setKodeProduct(rs.getInt(1));
				p.setNameProduct(rs.getString(2));
			}

		} catch (Exception e) {
			c.rollback();
			log.error("Error, when get product to database, cause :" + LoggerApp.printLog(e));
		} finally {
			if (c != null) {
				c.close();
			}

			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}
		}
		return p;

	}

	public void deleteById(Integer id) throws SQLException {
		Connection c = dataSource.getConnection();

		PreparedStatement ps = null;

		try {
			c.setAutoCommit(false);
			ps = c.prepareStatement(SQL_DELETE_PRODUCT_BYID);
			ps.setInt(1, id);

			ps.executeUpdate();
			c.commit();

		} catch (Exception e) {
			c.rollback();
			log.error("Error, when delete product to database, cause :" + LoggerApp.printLog(e));
		} finally {
			if (c != null) {
				c.close();
			}

			if (ps != null) {
				ps.close();
			}
		}
	}
}
