package cg.reponsitory;

import cg.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductReponsitory extends JpaRepository<Product,Long> {
    Iterable<Product>findAllByNameContaining(String name);
    Iterable<Product>findAllByOrderByPrice();
    @Query(value = "select * from product order by id desc LIMIT 4", nativeQuery = true)
    Iterable<Product> getTop4New();

    //"- Product: id, name, price
    //- Dùng SDR, Thymeleaf:
    //1. Hiện danh sách                           x
    //2. Sửa                                      x
    //3. Tìm theo tên+6                           x
    //4. Xóa                                      x
    //5. Thêm                                     x
    //Nâng cao:
    //1. Hiện danh sách sắp xếp tăng dần          x
    //2. Hiện 4 sản phẩm mới nhất
}
