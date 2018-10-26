/**
 * 创建日期:  2017年08月12日 15:50
 * 创建作者:  杨 强  <281455776@qq.com>
 */
package info.xiaomo.core.config.beans;

import lombok.Data;

import java.util.Map;

/**
 * 表描述
 *
 * @author YangQiang
 */
@Data
public class TableDesc {
    private Class clz;

    private String name;

    private int index;

    private int header;

    private int[] ignoreRow;

    private String[] primaryKeys;

    private Map<String, ColumnDesc> columns;

    public TableDesc(Class clz) {
        this.clz = clz;
    }

	public Class getClz() {
		return clz;
	}

	public void setClz(Class clz) {
		this.clz = clz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getHeader() {
		return header;
	}

	public void setHeader(int header) {
		this.header = header;
	}

	public int[] getIgnoreRow() {
		return ignoreRow;
	}

	public void setIgnoreRow(int[] ignoreRow) {
		this.ignoreRow = ignoreRow;
	}

	public String[] getPrimaryKeys() {
		return primaryKeys;
	}

	public void setPrimaryKeys(String[] primaryKeys) {
		this.primaryKeys = primaryKeys;
	}

	public Map<String, ColumnDesc> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnDesc> columns) {
		this.columns = columns;
	}
    
    
}
