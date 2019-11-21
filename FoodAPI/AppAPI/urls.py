from django.urls import path, include
from . import views
from rest_framework import routers
from django.conf import settings
from django.conf.urls.static import static

router = routers.DefaultRouter()
router.register('Rest', views.restView)
router.register('User', views.userView)
router.register('Item', views.itemView)
router.register('Rating', views.ratingView)


#all custom url endpoints
urlpatterns = [
    path('', include(router.urls)),
    path('Rest/Zip/<int:zipcode>/', views.restZip),
    path('Rest/Zip/<int:zipcode>/Cat/<int:category>/', views.restZipCat),
    path('Rest/ID/<int:pk>/', views.restID),
    path('Item/ID/<int:pk>/', views.itemID),
    path('Item/Rest/<int:restId>/', views.itemRest),
    path('User/ID/<str:pk>/', views.userID),
    path('Rating/Rest/<int:restId>/', views.ratingRest),
    path('Rating/User/<str:userEmail>/', views.ratingUser),
]

urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
