package Repository

import org.hibernate.Session
import util.HibernateUtil
import java.io.Serializable
import org.hibernate.HibernateException


abstract class CrudRepository<T, in ID : Serializable> {
    val sessionFactory = HibernateUtil.sessionFactory

    abstract fun getDomainClass(): Class<T>

    fun openSession(): Session {
        return sessionFactory!!.openSession()
    }

    /**
     * Busca uma entidade pelo ID
     */
    fun findById(id: ID): T? {
        val classType = getDomainClass()
        val session = openSession()
        session.transaction.begin()

        var entity: T? = null

        try {
            entity = session.get(classType, id)
            session.transaction.commit()
        } catch (e: Exception) {
            session.transaction.rollback()
        } finally {
            session.close()
        }

        return entity
    }

    /**
     * Retorna uma lista de entidades
     */
    fun findAll(): List<T> {
        val session = openSession()

        val classType = getDomainClass()
        val cq = session.criteriaBuilder.createQuery(classType)
        cq.from(classType)
        val entities: MutableList<T>

        try {
            entities = session.createQuery(cq).resultList
            return entities
        } catch (he: HibernateException) {
            he.printStackTrace()
        } finally {
            session.close()
        }

        return mutableListOf()
    }

    /**
     * Salva ou atualiza entidade
     */
    fun save(entity: T): T? {
        val session = openSession()
        session.transaction.begin()

        try {
            session.saveOrUpdate(entity)
            session.transaction.commit()
            return entity
        } catch (e: RuntimeException) {
            session.transaction.rollback()
        } finally {
            session.close()
        }

        return null
    }

    fun delete(entity: T) {
        val session = openSession()
        session.transaction.begin()

        try {
            session.delete(entity)
            session.transaction.commit()
        } catch (e: RuntimeException) {
            session.transaction.rollback()
        } finally {
            session.close()
        }
    }

    fun delete(id: ID) {
        val entity = findById(id)

        if (entity != null) delete(entity)
    }
}