package org.store.clothstar.product.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.store.clothstar.product.domain.Product;
import org.store.clothstar.product.domain.type.ProductStatus;
import org.store.clothstar.product.dto.ProductDetailResponse;
import org.store.clothstar.product.dto.ProductResponse;
import org.store.clothstar.product.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;

@DisplayName("비즈니스 로직 - Product")
@ActiveProfiles("dev")
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @DisplayName("product_id로 상품 단건 조회에 성공한다.")
    @Test
    public void givenProductId_whenGetProductById_thenProductReturned() {
        // given
        Long productId = 1L;
        Product product = Product.builder()
                .productId(productId)
                .name("오구 키링")
                .price(13000)
                .stock(20)
                .status(ProductStatus.COMING_SOON)
                .build();

        BDDMockito.given(productRepository.selectByProductId(anyLong())).willReturn(product);

        // when
        ProductDetailResponse response = productService.getProduct(productId);

        // then
        assertThat(response).isNotNull();
        assertThat(response.getName()).isEqualTo("오구 키링");
        assertThat(response.getPrice()).isEqualTo(13000);
        assertThat(response.getStock()).isEqualTo(20);
        assertThat(response.getProductStatus()).isEqualTo(ProductStatus.COMING_SOON);
    }

    @DisplayName("deleted_at이 null인 상품 리스트 조회에 성공한다.")
    @Test
    public void givenProducts_whenGetProducsList_thenGetProductsWhereDeletedAtIsNull() {
        // given
        List<Product> products = new ArrayList<>();
        Product product1 = Product.builder()
                .productId(1L)
                .name("오구 키링")
                .price(13000)
                .stock(20)
                .status(ProductStatus.COMING_SOON)
                .build();
        Product product2 = Product.builder()
                .productId(2L)
                .name("오구 바디 필로우")
                .price(57000)
                .stock(30)
                .status(ProductStatus.FOR_SALE)
                .build();
        Product product3 = Product.builder()
                .productId(3L)
                .name("오구 볼펜")
                .price(7900)
                .stock(0)
                .status(ProductStatus.SOLD_OUT)
                .deletedAt(LocalDateTime.now()) // deleted_at이 null이 아닌 경우
                .build();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        BDDMockito.given(productRepository.selectAllProductsNotDeleted()).willReturn(products);

        // when
        List<ProductResponse> response = productService.getAllProduct();

        // then
        Mockito.verify(productRepository, Mockito.times(1)).selectAllProductsNotDeleted();
        assertThat(response).isNotNull();
        assertThat(response.size()).isEqualTo(3);
        assertThat(response.get(0).getName()).isEqualTo(product1.getName());
        assertThat(response.get(0).getPrice()).isEqualTo(product1.getPrice());
        assertThat(response.get(0).getStock()).isEqualTo(product1.getStock());
        assertThat(response.get(0).getProductStatus()).isEqualTo(product1.getStatus());
    }

    @DisplayName("유요한 상품 생성 Request가 들어오면 상품 생성에 성공한다.")
    @Test
    public void givenValidCreateProductRequest_whenCreateProduct_thenProductCreated() {

    }
}