package com.senex.timetable.di

import com.senex.timetable.data.api.ScheduleService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiServiceModule {
   @Singleton
   @Provides
   fun provideScheduleService(retrofit: Retrofit): ScheduleService =
      retrofit.create(ScheduleService::class.java)
}