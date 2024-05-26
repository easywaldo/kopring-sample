package kr.sample.kopringsample.product.application.service

import kr.sample.kopringsample.product.application.dto.CreateOrUpdateProductDto
import kr.sample.kopringsample.product.infra.repository.ProductEntity
import kr.sample.kopringsample.product.infra.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun createProduct(productEntity: ProductEntity) {
        productRepository.save(productEntity)
    }

    fun getProduct(id: Long) {
        productRepository.findById(id)
    }

    fun getProducts(): List<ProductEntity> {
        return productRepository.findAll()
    }

    fun deleteProduct(id: Long) {
        productRepository.deleteById(id)
    }

    fun updateProduct(id: Long, createOrUpdateProductDto: CreateOrUpdateProductDto) {
        ProductEntity(
            id = id,
            name = createOrUpdateProductDto.name,
            price = createOrUpdateProductDto.price
        ).let {
            productRepository.update(it)
        }
    }
}