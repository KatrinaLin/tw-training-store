org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/api/products'
    }
    response {
        status 200
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
        body(
            file("products.json")
        )
    }
}