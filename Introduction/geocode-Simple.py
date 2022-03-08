# Fetching a Longitude and Latitude - Simple
from geopy.geocoders import Nominatim

if __name__ == '__main__':
    address = '숭실대학교'
    user_agent = 'kim yoon seo'
    location = Nominatim(user_agent=user_agent).geocode(address)
    print(location.latitude, location.longitude)

