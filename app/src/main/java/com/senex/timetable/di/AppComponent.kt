package com.senex.timetable.di

import android.app.Application
import com.senex.timetable.presentation.TimetableApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ContextModule::class,
    ViewModelsModule::class,
    DatabaseModule::class,
    RetrofitModule::class,
    PreferencesModule::class,
    FragmentModule::class,
    RepositoryModule::class,
])
interface AppComponent : AndroidInjector<TimetableApplication> {

    override fun inject(app: TimetableApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }
}