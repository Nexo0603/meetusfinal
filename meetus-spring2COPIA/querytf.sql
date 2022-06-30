INSERT INTO localowner(id, lo_name, lo_lastname, lo_phone, lo_dni, lo_address, lo_email, lo_urltoimage) VALUES
	(1, 'Martin', 'Zuniga', '902144956', '72908326', 'Av Los Nenufares 542', 'jesuzuniga0603@gmail.com', 'https://static.wixstatic.com/media/ad3e65_9ab71b469c6e4bc8aa0d62d315844998~mv2_d_2258_2823_s_2.jpg/v1/fit/w_585,h_731,q_90/ad3e65_9ab71b469c6e4bc8aa0d62d315844998~mv2_d_2258_2823_s_2.jpg') ,
	(2, 'Alvaro', 'Gamonal', '938644906', '73008327', 'Av Faucett 5452', 'alvarogamonal0505@gmail.com', 'https://creamas.org/wp-content/uploads/2017/11/carnet.jpg'),
	(3, 'Erick', 'Hennings', '949203035', '71761630', 'Av Tomas Valle 13420', 'erickhennings2609@gmail.com', 'https://media.v2.siweb.es/uploaded_thumb_medium/409d16e4bfdd9d56bbcdede012883dd9/7853533_carnet_h.jpg' ),
	(4, 'Cesar', 'Cardenas', '977412166', '72384991', 'Av El Olivar 2912', 'cesarcardenas1012@gmail.com', 'https://media.istockphoto.com/photos/portrait-of-a-young-professional-man-picture-id1086350530?k=20&m=1086350530&s=612x612&w=0&h=jm9UE1LXqdf5R8qEHqQO9Dfelztap08t78bZF6rloPg=');

INSERT INTO locals(id, l_name, l_district, l_description, l_cost, localowner_id, l_urltoimage) VALUES
	(1, 'REUM', 'San Miguel', '200 People', '50.00', 1, 'https://i.pinimg.com/736x/db/82/b7/db82b7ebab54027c1c7a53b339bcfa90--lounge-bar-murcia.jpg'),
	(2, 'El Punto', 'Pueblo Libre', '150 People', '80.00', 2, 'https://i.blogs.es/6061c6/d595s_mxoae6zi8-1-/1366_2000.jpeg'),
	(3, 'A Gozar', 'Bellavista', '160 People', '70.00', 3, 'https://i0.wp.com/moovemag.com/wp-content/uploads/2013/08/monstorebarjakarta3.jpg?resize=499%2C332&ssl=1'),
	(4, 'Chilling', 'Magdalena del Mar', '120 People', '60.00', 4, 'https://elperuano.pe/fotografia//thumbnail/2021/01/14/000105629M.jpg');

INSERT INTO organizers(id, organizer_name, organizer_last_name, organizer_phone, organizer_dni, organizer_address, organizer_email, organizer_urltoimage) VALUES
	(1, 'Andrea', 'Ramirez', '945815112', '71613212', 'Av La Marina 616', 'andrearamirez@gmail.com', 'https://www.istockphoto.com/es/foto/foto-de-pasaporte-de-una-sonriente-mujer-de-negocios-turco-gm856599656-141136573'),
	(2, 'Noemi', 'Laveriano', '930320323', '71309992', 'Av Petit Thouars 1603', 'noemilaveriano@gmail.com', 'https://365enfoques.com/wp-content/uploads/2018/09/como-hacerse-uno-mismo-las-fotos-del-dni.jpg'),
	(3, 'Carla', 'Rodriguez', '960331261', '74916316', 'Av Canta Callao 3123', 'carlarodriguez@gmail.com', 'https://media.istockphoto.com/photos/portrait-of-a-dark-haired-woman-picture-id488692423?k=20&m=488692423&s=612x612&w=0&h=nHQKWDTAni7WrU0nlKnxsA4s4QY4qgpU1bL0b-xfdvQ='),
	(4, 'Stefano', 'Venegas', '975131313', '73166112', 'Av Universitaria 49112', 'stefanovenegas@gmail.com', 'https://media.istockphoto.com/photos/passport-picture-of-a-laughing-guy-in-a-grey-shirt-picture-id471015650?k=20&m=471015650&s=612x612&w=0&h=mPPoPo6LxnN3zen_WvpczLOJRoUMktyuFD3vWUuOuro=');

INSERT INTO guests(id, G_firstname, G_lastname, G_phone, G_dni, G_address, G_urltoimage) VALUES
	(1, 'Angel', 'Tamayo', '945897113', '73116166', 'Av Metropolitana 416', 'https://media.istockphoto.com/photos/passport-photo-of-a-guy-in-a-grey-shirt-picture-id473690882?k=20&m=473690882&s=612x612&w=0&h=W_QHHmo3Rw7WZ5cvGt-Ff-0QzkVuSUCIB7ISNf028j0='),
	(2, 'Jorge', 'Cardenal', '937446162', '70541669', 'Av Carlos Izaguirre 1693', 'https://media.istockphoto.com/photos/passport-photo-of-serious-brazilian-young-adult-man-with-braces-picture-id1315808211?k=20&m=1315808211&s=612x612&w=0&h=VmBH7yrF7EQqPVQu9wAfge6opadEbvJf3OpOX9PARPg='),
	(3, 'Ian', 'Cardenas', '916231306', '78161616', 'Av Precursores 9313', 'https://us.123rf.com/450wm/koldunovaaa/koldunovaaa1809/koldunovaaa180900058/108050218-foto-para-documento-o-c%C3%A9dula-de-pasaporte-hombre-cauc%C3%A1sico-maduro-en-traje-y-camisa-blanca-.jpg?ver=6'),
	(4, 'Pedro', 'Lopez', '984651139', '73160133', 'Av Salaverry 4616', 'https://us.123rf.com/450wm/koldunovaaa/koldunovaaa1905/koldunovaaa190500340/123744687-foto-de-identificaci%C3%B3n-de-un-chico-con-camisa-a-cuadros-y-camiseta-rosa.jpg?ver=6');