package groovy

import com.example.springdemo.test.DemoService

beans {
    demoService2(DemoService){
    }
}

//beans {
//    dataSource(BasicDataSource) {
//        driverClassName = "org.hsqldb.jdbcDriver"
//        url = "jdbc:hsqldb:mem:grailsDB"
//        username = "sa"
//        password = ""
//        settings = [mynew:"setting"]
//    }
//    sessionFactory(SessionFactory) {
//        dataSource = dataSource
//    }
//    myService(MyService) {
//        nestedBean = { AnotherBean bean ->
//            dataSource = dataSource
//        }
//    }
//}