package cz.tomasdvorak.sqlkeywords.dto;


public final class PropertyIdentificator {
    private final Class<?> clazz;
    private final String fieldName;
    private final String columnName;

    public PropertyIdentificator(Class<?> clazz, String fieldName, String columnName) {
        this.clazz = clazz;
        this.fieldName = fieldName;
        this.columnName = columnName;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getColumnName() {
        return columnName;
    }

    @Override
    public String toString() {
        return clazz.getName() + "#" + fieldName + ":" + columnName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyIdentificator that = (PropertyIdentificator) o;

        if (clazz != null ? !clazz.equals(that.clazz) : that.clazz != null) return false;
        if (columnName != null ? !columnName.equals(that.columnName) : that.columnName != null) return false;
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clazz != null ? clazz.hashCode() : 0;
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        result = 31 * result + (columnName != null ? columnName.hashCode() : 0);
        return result;
    }
}
