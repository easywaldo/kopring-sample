package kr.sample.kopringsample.product.application.dto

import kr.sample.kopringsample.product.infra.repository.ProductEntity

data class CreateOrUpdateProductDto(
    val name: String,
    val price: Int
) {
    fun toEntity(): ProductEntity {
        return ProductEntity(name=name, price=price)
    }
}
