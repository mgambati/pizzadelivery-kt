package util

import org.hibernate.SessionFactory
import org.hibernate.boot.MetadataSources
import org.hibernate.boot.registry.StandardServiceRegistry
import org.hibernate.boot.registry.StandardServiceRegistryBuilder

object HibernateUtil {
    // Create Registry
    private val registry: StandardServiceRegistry = StandardServiceRegistryBuilder().configure().build()
    var sessionFactory: SessionFactory? = null

    init {
        try {
            // Create sources
            val sources = MetadataSources(registry)

            // Create metadata
            val metadata = sources.metadataBuilder.build()

            // Create Session Factory
            sessionFactory = metadata.sessionFactoryBuilder.build()
        } catch (e: Exception) {
            e.printStackTrace()
            shutdown()
        }
    }

    fun shutdown() {
        StandardServiceRegistryBuilder.destroy(registry)
    }
}