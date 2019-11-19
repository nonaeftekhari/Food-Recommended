from django.urls import path, include
from . import views
from rest_framework import routers
from django.conf import settings
from django.conf.urls.static import static


#all custom url endpoints
urlpatterns = [
    path('Rest/', views.restList),
    path('Rest/ID/<int:pk>/', views.restID),
    path('Rest/Zip/<int:zipcode>/', views.restZip),
    path('Item/', views.itemList),
    path('Item/ID/<int:pk>/', views.itemID),
    path('Item/Rest/<int:restId>/', views.itemRest),
    path('User/', views.userList),
    path('User/ID/<str:pk>/', views.userID),
    path('Rating/', views.ratingList),
    path('Rating/Rest/<int:restId>/', views.ratingRest),
]

urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)