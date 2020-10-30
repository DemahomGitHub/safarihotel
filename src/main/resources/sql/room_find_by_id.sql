select id,
       room_number,
       short_description,
       long_description,
       price_per_night,
       created_at
from Room
where id = ?