package kr.sample.kopringsample.product.infra.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface ProductRepository {
    fun save(productEntity: ProductEntity): ProductEntity
    fun findById(id: Long): ProductEntity?
    fun findAll(): List<ProductEntity>
    fun deleteById(id: Long)
    fun update(productEntity: ProductEntity): ProductEntity
}

@Repository
interface ProductJpaRepository : JpaRepository<ProductEntity, Long>

@Repository
class ProductRepositoryImpl(private val productJpaRepository: ProductJpaRepository) : ProductRepository {
    override fun save(productEntity: ProductEntity): ProductEntity {
        return productJpaRepository.save(productEntity)
    }

    override fun findById(id: Long): ProductEntity? {
        return productJpaRepository.findById(id).orElse(null)
    }

    override fun findAll(): List<ProductEntity> {
        return productJpaRepository.findAll()
    }

    override fun deleteById(id: Long) {
        productJpaRepository.deleteById(id)
    }

    override fun update(productEntity: ProductEntity): ProductEntity {
        return productJpaRepository.save(productEntity)
    }
}