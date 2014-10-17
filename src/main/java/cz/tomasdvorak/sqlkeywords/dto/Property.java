package cz.tomasdvorak.sqlkeywords.dto;


public final class Property {
    private final Class<?> clazz;
    private final String fieldName;
    private final String columnName;

    public Property(final Class<?> clazz, final String fieldName, final String columnName) {
        this.clazz = clazz;
        this.fieldName = fieldName;
        this.columnName = columnName;
    }

    public String getComparableName() {
        return columnName.toLowerCase();
    }

    @Override
    public String toString() {
        return clazz.getName() + "#" + fieldName + ":" + columnName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Property that = (Property) o;

        return !(clazz != null ? !clazz.equals(that.clazz) : that.clazz != null)
            && !(columnName != null ? !columnName.equals(that.columnName) : that.columnName != null)
            && !(fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null);

    }

    @Override
    public int hashCode() {
        int result = clazz != null ? clazz.hashCode() : 0;
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        result = 31 * result + (columnName != null ? columnName.hashCode() : 0);
        return result;
    }
}
