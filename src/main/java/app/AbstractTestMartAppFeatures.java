package app;

import model.contract.CartService;
import model.contract.ProductService;
import model.contract.UserService;
import model.dto.CartDto;
import model.dto.CategoryDto;
import model.dto.ProductDto;
import model.dto.UserDto;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AbstractTestMartAppFeatures {

	private CartService<CartDto> cartService;
	private ProductService<ProductDto, CategoryDto> productService;
	private UserService<UserDto> userService;

	public AbstractTestMartAppFeatures(CartService<CartDto> cartService, ProductService<ProductDto, CategoryDto> productService, UserService<UserDto> userService) {
		this.cartService = cartService;
		this.productService = productService;
		this.userService = userService;
	}

	/**
	 * Prints the titles of all products that have a rating less than or equal to the provided criteria.
	 * @param rating The rating threshold.
	 */
	public void getProductTitlesByWorseRating(double rating){
		List<ProductDto> allProducts = productService.getAllProducts();
		allProducts.forEach(productDto -> {
			if (productDto.getRating()<= rating){
				System.out.println(productDto);
			}
		});
	}

	/**
	 * Returns the cart with the highest total value.
	 * @returns The cart with the highest total value.
	 */
	public CartDto getCartWithHighestTotal(){
		List<CartDto> allCarts = cartService.getAllCarts();
		Optional<CartDto> cartWithTotalValue = allCarts.stream().max(Comparator.comparing(CartDto::getTotal));
		return cartWithTotalValue.get();
	}

	/**
	 * Returns the cart with the lowest total value.
	 * @returns The cart with the lowest total value.
	 */
	public CartDto getCartWithLowestTotal(){
		List<CartDto> allCarts = cartService.getAllCarts();
		Optional<CartDto> cartWithTotalValue = allCarts.stream().min(Comparator.comparing(CartDto::getTotal));
		return cartWithTotalValue.get();
	}

	/**
	 * Enriches the product information in a user's cart by adding product images.
	 * The current product information in a cart has limited fields.
	 * This method adds the `images` field for each product in a given user's cart.
	 * Note: This method only applies to the first element from the `carts[]` JSON response.
	 * @param userId The ID of the user whose cart's product information will be enriched.
	 * @returns A list of products with enriched information in the user's cart.
	 */
	public List<ProductDto> addProductImagesToUserCart(Integer userId){
		CartDto userCart = cartService.getUserCarts(userId).get(0); // Assuming the first element from the response

		List<ProductDto> products = userCart.getProductDtos();
		for (ProductDto product : products) {
			ProductDto fullProductInfo = productService.getProduct(product.getId());
			product.setImages(fullProductInfo.getImages());
		}
		return products;
	}
}