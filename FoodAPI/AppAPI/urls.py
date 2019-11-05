from django.urls import path, include
from . import views
from rest_framework import routers

router = routers.DefaultRouter()
router.register('Rest', views.restView)
router.register('Item', views.itemView)
router.register('User', views.userView)


urlpatterns = [
    path('', include(router.urls))
]
