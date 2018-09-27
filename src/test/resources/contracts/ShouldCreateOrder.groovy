org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/api/users/1/orders'
        headers {
            header('Content-Type', 'application/json;charset=UTF-8')
        }
        body("""
        [
            {
                "productId": 1,
                "quantity": 3
            },
            {
                "productId": 2,
                "quantity": 4
            }
        ]
        """)
    }
    response {
        status 200
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
        body("""
        [
            {
                "productId": 1,
                "quantity": 3
            },
            {
                "productId": 2,
                "quantity": 4
            }
        ]
        """)
    }
}