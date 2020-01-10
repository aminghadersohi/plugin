package com.aminghadersohi.plugin.core

interface PluginBuilder<Plugin, PluginContext> {
    val switch: PluginSwitch
    fun applicable(context: PluginContext): Boolean
    fun build(context: PluginContext): Plugin
}