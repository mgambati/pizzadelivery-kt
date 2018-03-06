package util

/**
 * Util para acessar relacionamentos com lazy loading
 */
fun runInTransaction(action: () -> Any) {
    val session = HibernateUtil.sessionFactory!!.openSession()
    session.transaction.begin()
    try {
        action()
        session.transaction.commit()
    } catch (e: Exception) {
        session.transaction.rollback()
    }
    session.close()
}