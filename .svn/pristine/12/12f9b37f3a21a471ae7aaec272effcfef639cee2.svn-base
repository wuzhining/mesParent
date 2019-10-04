package com.techsoft.service.product;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.techsoft.common.BusinessException;
import com.techsoft.common.CommonParam;
import com.techsoft.common.SQLException;
import com.techsoft.common.BaseDao;
import com.techsoft.common.BaseServiceImpl;
import com.techsoft.entity.common.ProductBom;
import com.techsoft.entity.common.ProductMaterial;
import com.techsoft.dao.product.ProductBomDao;
import com.techsoft.dao.product.ProductMaterialDao;

@Service
public class ProductBomServiceImpl extends BaseServiceImpl<ProductBom> implements ProductBomService {
	@Autowired
	private ProductBomDao productBomDao;
	@Autowired
	private ProductMaterialDao productMaterialDao;

	@Override
	public BaseDao<ProductBom> getBaseDao() {
		return productBomDao;
	}

	@Override
	public Class<ProductBom> getEntityClass() {
		return ProductBom.class;
	}

	@Override
	protected ProductBom insertEntity(ProductBom entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.insertEntity(entity, commonParam);
	}

	@Override
	protected ProductBom updatePartEntity(ProductBom entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updatePartEntity(entity, commonParam);
	}

	@Override
	protected ProductBom updateEntity(ProductBom entity, CommonParam commonParam)
			throws BusinessException, SQLException {
		return super.updateEntity(entity, commonParam);
	}

	@Override
	public List<ProductBom> selectListBomTree(Long id, CommonParam commonParam)
			throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		return productBomDao.selectListBomTree(id, commonParam);
	}					

	@Override
	public void insertGospellBom() throws BusinessException, SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			// Oracle8/8i/9i数据库(thin模式)
			String url = "jdbc:oracle:thin:@192.168.1.71:1530:Gospell";
			String user = "mes1";
			String password = "mes1";
			Connection conn = DriverManager.getConnection(url, user, password);
			// 建立Statement对象
			Statement stmt = conn.createStatement();
			// 建立PreparedStatement对象
			String sql = "select count(*) as a from R_MES_PRODUCT_BOM WHERE  PARENT_BOM_CODE='N/A'";
			ResultSet rs = stmt.executeQuery(sql);
			List<ProductBom> bomList = new ArrayList<>();
			int page_size = 50;
			int list_count = 0;
			Integer index = 0;
			String idString = "";
			Long productBomId = 0L;
			Long productSonBomId = 0L;
			Long bomId = productBomDao.getIdValue();
			DecimalFormat locationdf = new DecimalFormat("000000");
			while (rs.next()) {
				System.err.println("高斯贝尔BOM总记录数为：" + rs.getString("a"));
				// list_count = Integer.parseInt(rs.getString("a"));
				list_count = 2;
			}
			int export_times = list_count % page_size > 0 ? list_count / page_size + 1 : list_count / page_size;
			for (int a = 1; a <= export_times; a++) {
				bomList.clear();
				// 查出一级bom列表
				StringBuilder sb = new StringBuilder(300);
				Statement fatherBomStmt = conn.createStatement();
				sb.append("SELECT PF.* FROM (SELECT ROWNUM AS RN,DF.* FROM(");
				sb.append("SELECT DISTINCT  T1.BOM_CODE, T1.PARENT_BOM_CODE, T1.QUANTITY, T1.ATTRITION_RATE ");
				sb.append("  FROM MES1.R_MES_PRODUCT_BOM T1 WHERE T1.PARENT_BOM_CODE='N/A' ");
				sb.append(") DF)PF WHERE PF.RN >  (" + a + "-1)*" + "2" + " AND PF.RN < = " + a + "*" + "2"
						+ "");
				ResultSet fatherBomRs = fatherBomStmt.executeQuery(sb.toString());
				System.err.println("第" + a + "次循环");
				while (fatherBomRs.next()) {
					
					index++;
					idString = locationdf.format(index);
					productBomId = Long.valueOf(bomId.toString() + idString);
					ProductBom fatherBom = new ProductBom();
					fatherBom.setId(productBomId);
					fatherBom.setBomCode(fatherBomRs.getString("BOM_CODE"));
					fatherBom.setParentId(Long.parseLong("0"));
					fatherBom.setQuantity(Double.parseDouble(fatherBomRs.getString("QUANTITY")));
					fatherBom.setNumberLevel(1);
					fatherBom.setCreateUserId(Long.parseLong("1"));
					fatherBom.setModifyUserId(Long.parseLong("1"));
					fatherBom.setTenantId(Long.parseLong("1"));
					fatherBom.setParentIdes(productBomId.toString());
					// 找到对应的物品与物品规格ID
					ProductMaterial productMaterial = new ProductMaterial();
					try {
						productMaterial = productMaterialDao.selectByCode(fatherBom.getBomCode());
					} catch (BusinessException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if (productMaterial != null) {
						//throw new BusinessException("该bom找不到对应的物品规格，无法同步");
						// 赋值
						fatherBom.setMaterialId(productMaterial.getId());
						fatherBom.setProductId(productMaterial.getProductId());
					}
					
					bomList.add(fatherBom);
					
					
					// 找出该bom下面所有bom清单
					StringBuilder bomSql = new StringBuilder(300);
					Statement  bomStmt = conn.createStatement();
					bomSql.append(
							"SELECT DISTINCT T1.BOM_CODE, T1.PARENT_BOM_CODE, T1.QUANTITY, T1.ATTRITION_RATE,level ");
					bomSql.append(
							" FROM MES1.R_MES_PRODUCT_BOM T1 where BOM_CODE !='" + fatherBomRs.getString("BOM_CODE") + "'");
					bomSql.append(" START WITH BOM_CODE = '" + fatherBomRs.getString("BOM_CODE")
							+ "' CONNECT BY PRIOR BOM_CODE = PARENT_BOM_CODE order by level");
					ResultSet bomRs = bomStmt.executeQuery(bomSql.toString());
					while (bomRs.next()) {
						index++;
						idString = locationdf.format(index);
						productSonBomId = Long.valueOf(bomId.toString() + idString);
						ProductBom sonBom = new ProductBom();
						sonBom.setId(productSonBomId);
						sonBom.setBomCode(bomRs.getString("BOM_CODE"));
						for (ProductBom productBom : bomList) {
							if (productBom.getBomCode().equals(bomRs.getString("PARENT_BOM_CODE"))) {
								sonBom.setParentId(productBom.getId());
								sonBom.setParentIdes(productBom.getParentIdes()+","+sonBom.getId());
							}
						}
						sonBom.setQuantity(Double.parseDouble(bomRs.getString("QUANTITY")));
						sonBom.setNumberLevel(Integer.parseInt(bomRs.getString("level")));
						sonBom.setCreateUserId(Long.parseLong("1"));
						sonBom.setModifyUserId(Long.parseLong("1"));
						sonBom.setTenantId(Long.parseLong("1"));
						// 找到对应的物品与物品规格ID
						ProductMaterial material = new ProductMaterial();
						try {
							material = productMaterialDao.selectByCode(sonBom.getBomCode());
						} catch (BusinessException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						if (material != null) {
							//throw new BusinessException("该bom找不到对应的物品规格，无法同步");
							// 赋值
							sonBom.setMaterialId(material.getId());
							sonBom.setProductId(material.getProductId());
						}
						bomList.add(sonBom);
					}
					bomRs.close();
					bomStmt.close();
				}
				productBomDao.insertBatchProductBom(bomList);
				fatherBomRs.close();
				fatherBomStmt.close();
			}
			System.err.println("同步完成同步完成同步完成同步完成同步完成同步完成同步完成同步完成");
			rs.close();
			stmt.close();
			conn.close();
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
