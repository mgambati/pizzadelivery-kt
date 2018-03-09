package controller

abstract class InitializeByData<D> {
    abstract fun onDataReceive(data: D)
}