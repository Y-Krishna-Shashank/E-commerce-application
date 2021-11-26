public interface ProductFilter {

    public void priceRange(int min, int max);
    public void findBrand(String brand_name);
    public void  materialFilter(String material_type);
    public void conditionFilter(Condition condition);


}
