# crazy-hotel-provider
Crazy Hotel Provider

# Description
This is Api for hotel provider conten getHotel REST service with mock data

### Swagger Api Document URL:
```
http://localhost:8082/swagger-ui.html#
You can try call REST api via swagger documentation
```


### Api Content
```
getHotel REST API,
Swagger api documentation,
integration test case,
controller test case,
api gateway for call mulit use case independent on other usecase,
service part for call use case and check business validation before access use case and model,
use case implementation,
repository work as database for get data (mock data),
```


###
```
{fromDate='2019-01-01T00:00:00.000Z', toDate='2019-12-31T00:00:00.000Z', city='AUH', numberOfAdults=10, provider='null', hotelName='Marriott Hotel', farePerNight=100, amenities=[Wifi, parking, TV], rate='**,*****', discount='0'}
{fromDate='2019-01-01T00:00:00.000Z', toDate='2019-12-31T00:00:00.000Z', city='AUH', numberOfAdults=10, provider='null', hotelName='Grand Hotel', farePerNight=30, amenities=[Wifi, parking, TV], rate='*,*****', discount='0'}
{fromDate='2019-01-01T00:00:00.000Z', toDate='2019-06-30T00:00:00.000Z', city='AUH', numberOfAdults=10, provider='null', hotelName='Queen Hotel', farePerNight=50, amenities=[Wifi, parking, TV], rate='***,*****', discount='0'}
{fromDate='2019-05-01T00:00:00.000Z', toDate='2019-12-31T00:00:00.000Z', city='AUH', numberOfAdults=10, provider='null', hotelName='Four Seasons Resort Dubai', farePerNight=150, amenities=[Wifi, parking], rate='****,*****', discount='10%'}
{fromDate='2019-05-01T00:00:00.000Z', toDate='2019-12-31T00:00:00.000Z', city='DXB', numberOfAdults=10, provider='null', hotelName='Four Seasons Resort Dubai', farePerNight=150, amenities=[Wifi, parking, TV, Smoking Room], rate='*****,*****', discount=''}
{fromDate='2019-01-01T00:00:00.000Z', toDate='2019-12-31T00:00:00.000Z', city='DXB', numberOfAdults=10, provider='null', hotelName='Regency Palace Dubai', farePerNight=90, amenities=[Wifi, TV, Smoking Room], rate='****,*****', discount=''}
{fromDate='2019-01-01T00:00:00.000Z', toDate='2019-12-31T00:00:00.000Z', city='DXB', numberOfAdults=10, provider='null', hotelName='Rayan Dubai', farePerNight=60, amenities=[Wifi, Smoking Room], rate='***,*****', discount='30'}
{fromDate='2019-01-01T00:00:00.000Z', toDate='2019-12-31T00:00:00.000Z', city='DXB', numberOfAdults=10, provider='null', hotelName='Royal Dubai', farePerNight=200, amenities=[Wifi, TV, Smoking Room], rate='*****,*****', discount='30'}

```