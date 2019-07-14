package de.bib.spring.simple.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import de.bib.spring.simple.jdbc.model.Product;
import de.bib.spring.simple.jdbc.util.LoggerApp;
import de.bib.spring.simple.jdbc.util.ResourceDatabase;

/**
 * Class handle connection model product to database .
 * 
 * @author User
 *
 */
public class ProductDao {

	private Logger log = Logger.getLogger(ProductDao.class.getName());
	private static final String SQL_INSERT_PRODUCT = "insert into Product (Kode_Product,Nama_Product,Desc_Product,Unit_Product,Harga_Product) values (?,?,?,?,?)";

	/**
	 * Create connection database
	 * 
	 * @return
	 */
	private Connection conn() {
		ResourceDatabase rd;
		try {
			rd = new ResourceDatabase();
			Connection conn = rd.getConnection();

			return conn;
		} catch (Exception e) {
			log.error("Error, when create connection cause :" + LoggerApp.printLog(e));
		}
		return null;

	}

	/**
	 * Handle insert product to database.
	 * 
	 * @param p
	 * @throws SQLException
	 */
	public void simpan(Product p) throws SQLException {
		Connection c = conn();

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
}
