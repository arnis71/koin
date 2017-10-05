package org.koin.dsl.module

import org.koin.KoinContext
import org.koin.dsl.context.Context
import org.koin.dsl.context.Scope
import kotlin.reflect.KClass


/**
 * Module class - Help define beans within actual context
 * @author - Arnaud GIULIANI
 */
abstract class Module {

    lateinit var koinContext: KoinContext

    /**
     * module's context
     */
    abstract fun context(): Context

    /**
     * Create Context function
     */
    fun declareContext(clazz: KClass<*>? = null, init: Context.() -> Unit)
            = Context(clazz?.let { Scope(it) } ?: Scope.root(), koinContext).apply(init)

}
