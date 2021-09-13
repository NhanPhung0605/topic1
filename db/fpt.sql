PGDMP         	                y            fpt_test    13.3    13.3 B               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16394    fpt_test    DATABASE     i   CREATE DATABASE fpt_test WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Vietnamese_Vietnam.1258';
    DROP DATABASE fpt_test;
                postgres    false            �            1259    23952    form_detail_tbl    TABLE     �   CREATE TABLE public.form_detail_tbl (
    form_detail_id bigint NOT NULL,
    field_name character varying(255),
    field_type integer,
    form_id bigint
);
 #   DROP TABLE public.form_detail_tbl;
       public         heap    postgres    false            �            1259    23950 "   form_detail_tbl_form_detail_id_seq    SEQUENCE     �   CREATE SEQUENCE public.form_detail_tbl_form_detail_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.form_detail_tbl_form_detail_id_seq;
       public          postgres    false    201                       0    0 "   form_detail_tbl_form_detail_id_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.form_detail_tbl_form_detail_id_seq OWNED BY public.form_detail_tbl.form_detail_id;
          public          postgres    false    200            �            1259    23960    form_tbl    TABLE     d   CREATE TABLE public.form_tbl (
    form_id bigint NOT NULL,
    form_name character varying(255)
);
    DROP TABLE public.form_tbl;
       public         heap    postgres    false            �            1259    23958    form_tbl_form_id_seq    SEQUENCE     }   CREATE SEQUENCE public.form_tbl_form_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.form_tbl_form_id_seq;
       public          postgres    false    203                       0    0    form_tbl_form_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.form_tbl_form_id_seq OWNED BY public.form_tbl.form_id;
          public          postgres    false    202            �            1259    23968    form_value_detail_tbl    TABLE     �   CREATE TABLE public.form_value_detail_tbl (
    form_value_detail_id bigint NOT NULL,
    value_bool boolean,
    value_num bigint,
    form_detail_id bigint,
    form_value_id bigint
);
 )   DROP TABLE public.form_value_detail_tbl;
       public         heap    postgres    false            �            1259    23966 .   form_value_detail_tbl_form_value_detail_id_seq    SEQUENCE     �   CREATE SEQUENCE public.form_value_detail_tbl_form_value_detail_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 E   DROP SEQUENCE public.form_value_detail_tbl_form_value_detail_id_seq;
       public          postgres    false    205            	           0    0 .   form_value_detail_tbl_form_value_detail_id_seq    SEQUENCE OWNED BY     �   ALTER SEQUENCE public.form_value_detail_tbl_form_value_detail_id_seq OWNED BY public.form_value_detail_tbl.form_value_detail_id;
          public          postgres    false    204            �            1259    23976    form_value_image_tbl    TABLE     �   CREATE TABLE public.form_value_image_tbl (
    form_value_image_id bigint NOT NULL,
    image_path character varying(255),
    form_value_id bigint
);
 (   DROP TABLE public.form_value_image_tbl;
       public         heap    postgres    false            �            1259    23974 ,   form_value_image_tbl_form_value_image_id_seq    SEQUENCE     �   CREATE SEQUENCE public.form_value_image_tbl_form_value_image_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 C   DROP SEQUENCE public.form_value_image_tbl_form_value_image_id_seq;
       public          postgres    false    207            
           0    0 ,   form_value_image_tbl_form_value_image_id_seq    SEQUENCE OWNED BY     }   ALTER SEQUENCE public.form_value_image_tbl_form_value_image_id_seq OWNED BY public.form_value_image_tbl.form_value_image_id;
          public          postgres    false    206            �            1259    23984    form_value_tbl    TABLE     �   CREATE TABLE public.form_value_tbl (
    form_value_id bigint NOT NULL,
    created_date timestamp without time zone,
    form_id bigint
);
 "   DROP TABLE public.form_value_tbl;
       public         heap    postgres    false            �            1259    23982     form_value_tbl_form_value_id_seq    SEQUENCE     �   CREATE SEQUENCE public.form_value_tbl_form_value_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.form_value_tbl_form_value_id_seq;
       public          postgres    false    209                       0    0     form_value_tbl_form_value_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.form_value_tbl_form_value_id_seq OWNED BY public.form_value_tbl.form_value_id;
          public          postgres    false    208            �            1259    23992    role_tbl    TABLE     �   CREATE TABLE public.role_tbl (
    role_id bigint NOT NULL,
    role_code character varying(255),
    role_name character varying(255)
);
    DROP TABLE public.role_tbl;
       public         heap    postgres    false            �            1259    23990    role_tbl_role_id_seq    SEQUENCE     }   CREATE SEQUENCE public.role_tbl_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.role_tbl_role_id_seq;
       public          postgres    false    211                       0    0    role_tbl_role_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.role_tbl_role_id_seq OWNED BY public.role_tbl.role_id;
          public          postgres    false    210            �            1259    24001    user_role_tbl    TABLE     `   CREATE TABLE public.user_role_tbl (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);
 !   DROP TABLE public.user_role_tbl;
       public         heap    postgres    false            �            1259    24006    user_tbl    TABLE     �   CREATE TABLE public.user_tbl (
    user_id bigint NOT NULL,
    enable boolean,
    name character varying(255),
    password character varying(255),
    username character varying(255)
);
    DROP TABLE public.user_tbl;
       public         heap    postgres    false            �            1259    24004    user_tbl_user_id_seq    SEQUENCE     }   CREATE SEQUENCE public.user_tbl_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.user_tbl_user_id_seq;
       public          postgres    false    214                       0    0    user_tbl_user_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.user_tbl_user_id_seq OWNED BY public.user_tbl.user_id;
          public          postgres    false    213            L           2604    23955    form_detail_tbl form_detail_id    DEFAULT     �   ALTER TABLE ONLY public.form_detail_tbl ALTER COLUMN form_detail_id SET DEFAULT nextval('public.form_detail_tbl_form_detail_id_seq'::regclass);
 M   ALTER TABLE public.form_detail_tbl ALTER COLUMN form_detail_id DROP DEFAULT;
       public          postgres    false    201    200    201            M           2604    23963    form_tbl form_id    DEFAULT     t   ALTER TABLE ONLY public.form_tbl ALTER COLUMN form_id SET DEFAULT nextval('public.form_tbl_form_id_seq'::regclass);
 ?   ALTER TABLE public.form_tbl ALTER COLUMN form_id DROP DEFAULT;
       public          postgres    false    202    203    203            N           2604    23971 *   form_value_detail_tbl form_value_detail_id    DEFAULT     �   ALTER TABLE ONLY public.form_value_detail_tbl ALTER COLUMN form_value_detail_id SET DEFAULT nextval('public.form_value_detail_tbl_form_value_detail_id_seq'::regclass);
 Y   ALTER TABLE public.form_value_detail_tbl ALTER COLUMN form_value_detail_id DROP DEFAULT;
       public          postgres    false    205    204    205            O           2604    23979 (   form_value_image_tbl form_value_image_id    DEFAULT     �   ALTER TABLE ONLY public.form_value_image_tbl ALTER COLUMN form_value_image_id SET DEFAULT nextval('public.form_value_image_tbl_form_value_image_id_seq'::regclass);
 W   ALTER TABLE public.form_value_image_tbl ALTER COLUMN form_value_image_id DROP DEFAULT;
       public          postgres    false    207    206    207            P           2604    23987    form_value_tbl form_value_id    DEFAULT     �   ALTER TABLE ONLY public.form_value_tbl ALTER COLUMN form_value_id SET DEFAULT nextval('public.form_value_tbl_form_value_id_seq'::regclass);
 K   ALTER TABLE public.form_value_tbl ALTER COLUMN form_value_id DROP DEFAULT;
       public          postgres    false    209    208    209            Q           2604    23995    role_tbl role_id    DEFAULT     t   ALTER TABLE ONLY public.role_tbl ALTER COLUMN role_id SET DEFAULT nextval('public.role_tbl_role_id_seq'::regclass);
 ?   ALTER TABLE public.role_tbl ALTER COLUMN role_id DROP DEFAULT;
       public          postgres    false    211    210    211            R           2604    24009    user_tbl user_id    DEFAULT     t   ALTER TABLE ONLY public.user_tbl ALTER COLUMN user_id SET DEFAULT nextval('public.user_tbl_user_id_seq'::regclass);
 ?   ALTER TABLE public.user_tbl ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    213    214    214            �          0    23952    form_detail_tbl 
   TABLE DATA           Z   COPY public.form_detail_tbl (form_detail_id, field_name, field_type, form_id) FROM stdin;
    public          postgres    false    201   @Q       �          0    23960    form_tbl 
   TABLE DATA           6   COPY public.form_tbl (form_id, form_name) FROM stdin;
    public          postgres    false    203   �Q       �          0    23968    form_value_detail_tbl 
   TABLE DATA           {   COPY public.form_value_detail_tbl (form_value_detail_id, value_bool, value_num, form_detail_id, form_value_id) FROM stdin;
    public          postgres    false    205   �Q       �          0    23976    form_value_image_tbl 
   TABLE DATA           ^   COPY public.form_value_image_tbl (form_value_image_id, image_path, form_value_id) FROM stdin;
    public          postgres    false    207   R       �          0    23984    form_value_tbl 
   TABLE DATA           N   COPY public.form_value_tbl (form_value_id, created_date, form_id) FROM stdin;
    public          postgres    false    209   sR       �          0    23992    role_tbl 
   TABLE DATA           A   COPY public.role_tbl (role_id, role_code, role_name) FROM stdin;
    public          postgres    false    211   �R       �          0    24001    user_role_tbl 
   TABLE DATA           9   COPY public.user_role_tbl (user_id, role_id) FROM stdin;
    public          postgres    false    212   S                  0    24006    user_tbl 
   TABLE DATA           M   COPY public.user_tbl (user_id, enable, name, password, username) FROM stdin;
    public          postgres    false    214   ,S                  0    0 "   form_detail_tbl_form_detail_id_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.form_detail_tbl_form_detail_id_seq', 1, false);
          public          postgres    false    200                       0    0    form_tbl_form_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.form_tbl_form_id_seq', 1, false);
          public          postgres    false    202                       0    0 .   form_value_detail_tbl_form_value_detail_id_seq    SEQUENCE SET     ]   SELECT pg_catalog.setval('public.form_value_detail_tbl_form_value_detail_id_seq', 14, true);
          public          postgres    false    204                       0    0 ,   form_value_image_tbl_form_value_image_id_seq    SEQUENCE SET     Z   SELECT pg_catalog.setval('public.form_value_image_tbl_form_value_image_id_seq', 3, true);
          public          postgres    false    206                       0    0     form_value_tbl_form_value_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.form_value_tbl_form_value_id_seq', 7, true);
          public          postgres    false    208                       0    0    role_tbl_role_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.role_tbl_role_id_seq', 1, true);
          public          postgres    false    210                       0    0    user_tbl_user_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.user_tbl_user_id_seq', 1, true);
          public          postgres    false    213            T           2606    23957 $   form_detail_tbl form_detail_tbl_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.form_detail_tbl
    ADD CONSTRAINT form_detail_tbl_pkey PRIMARY KEY (form_detail_id);
 N   ALTER TABLE ONLY public.form_detail_tbl DROP CONSTRAINT form_detail_tbl_pkey;
       public            postgres    false    201            V           2606    23965    form_tbl form_tbl_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.form_tbl
    ADD CONSTRAINT form_tbl_pkey PRIMARY KEY (form_id);
 @   ALTER TABLE ONLY public.form_tbl DROP CONSTRAINT form_tbl_pkey;
       public            postgres    false    203            X           2606    23973 0   form_value_detail_tbl form_value_detail_tbl_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.form_value_detail_tbl
    ADD CONSTRAINT form_value_detail_tbl_pkey PRIMARY KEY (form_value_detail_id);
 Z   ALTER TABLE ONLY public.form_value_detail_tbl DROP CONSTRAINT form_value_detail_tbl_pkey;
       public            postgres    false    205            Z           2606    23981 .   form_value_image_tbl form_value_image_tbl_pkey 
   CONSTRAINT     }   ALTER TABLE ONLY public.form_value_image_tbl
    ADD CONSTRAINT form_value_image_tbl_pkey PRIMARY KEY (form_value_image_id);
 X   ALTER TABLE ONLY public.form_value_image_tbl DROP CONSTRAINT form_value_image_tbl_pkey;
       public            postgres    false    207            \           2606    23989 "   form_value_tbl form_value_tbl_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public.form_value_tbl
    ADD CONSTRAINT form_value_tbl_pkey PRIMARY KEY (form_value_id);
 L   ALTER TABLE ONLY public.form_value_tbl DROP CONSTRAINT form_value_tbl_pkey;
       public            postgres    false    209            ^           2606    24000    role_tbl role_tbl_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.role_tbl
    ADD CONSTRAINT role_tbl_pkey PRIMARY KEY (role_id);
 @   ALTER TABLE ONLY public.role_tbl DROP CONSTRAINT role_tbl_pkey;
       public            postgres    false    211            `           2606    24018 %   role_tbl uk_4sja38wh4qqg2tt7gyls500pn 
   CONSTRAINT     e   ALTER TABLE ONLY public.role_tbl
    ADD CONSTRAINT uk_4sja38wh4qqg2tt7gyls500pn UNIQUE (role_name);
 O   ALTER TABLE ONLY public.role_tbl DROP CONSTRAINT uk_4sja38wh4qqg2tt7gyls500pn;
       public            postgres    false    211            d           2606    24020 *   user_role_tbl uk_64bo69a8fheytgai9kjyqlgsc 
   CONSTRAINT     h   ALTER TABLE ONLY public.user_role_tbl
    ADD CONSTRAINT uk_64bo69a8fheytgai9kjyqlgsc UNIQUE (role_id);
 T   ALTER TABLE ONLY public.user_role_tbl DROP CONSTRAINT uk_64bo69a8fheytgai9kjyqlgsc;
       public            postgres    false    212            f           2606    24022 %   user_tbl uk_b18fcwxl1ukojdp11u46nwwoq 
   CONSTRAINT     `   ALTER TABLE ONLY public.user_tbl
    ADD CONSTRAINT uk_b18fcwxl1ukojdp11u46nwwoq UNIQUE (name);
 O   ALTER TABLE ONLY public.user_tbl DROP CONSTRAINT uk_b18fcwxl1ukojdp11u46nwwoq;
       public            postgres    false    214            b           2606    24016 %   role_tbl uk_d1yf0dgpv83w4gxnnww5lxod3 
   CONSTRAINT     e   ALTER TABLE ONLY public.role_tbl
    ADD CONSTRAINT uk_d1yf0dgpv83w4gxnnww5lxod3 UNIQUE (role_code);
 O   ALTER TABLE ONLY public.role_tbl DROP CONSTRAINT uk_d1yf0dgpv83w4gxnnww5lxod3;
       public            postgres    false    211            h           2606    24014    user_tbl user_tbl_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.user_tbl
    ADD CONSTRAINT user_tbl_pkey PRIMARY KEY (user_id);
 @   ALTER TABLE ONLY public.user_tbl DROP CONSTRAINT user_tbl_pkey;
       public            postgres    false    214            k           2606    24033 1   form_value_detail_tbl fk192g4kqhm00fyga04ysaurb83    FK CONSTRAINT     �   ALTER TABLE ONLY public.form_value_detail_tbl
    ADD CONSTRAINT fk192g4kqhm00fyga04ysaurb83 FOREIGN KEY (form_value_id) REFERENCES public.form_value_tbl(form_value_id);
 [   ALTER TABLE ONLY public.form_value_detail_tbl DROP CONSTRAINT fk192g4kqhm00fyga04ysaurb83;
       public          postgres    false    209    205    2908            o           2606    24053 )   user_role_tbl fk53b8oon0dkfbdetl5bsqfq0wn    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_role_tbl
    ADD CONSTRAINT fk53b8oon0dkfbdetl5bsqfq0wn FOREIGN KEY (user_id) REFERENCES public.user_tbl(user_id);
 S   ALTER TABLE ONLY public.user_role_tbl DROP CONSTRAINT fk53b8oon0dkfbdetl5bsqfq0wn;
       public          postgres    false    2920    214    212            i           2606    24023 +   form_detail_tbl fk7ab4kiys2cktmvu5nalx4ucrb    FK CONSTRAINT     �   ALTER TABLE ONLY public.form_detail_tbl
    ADD CONSTRAINT fk7ab4kiys2cktmvu5nalx4ucrb FOREIGN KEY (form_id) REFERENCES public.form_tbl(form_id);
 U   ALTER TABLE ONLY public.form_detail_tbl DROP CONSTRAINT fk7ab4kiys2cktmvu5nalx4ucrb;
       public          postgres    false    2902    201    203            m           2606    24043 *   form_value_tbl fkcnqt47kst3puua4lgjjfpy24r    FK CONSTRAINT     �   ALTER TABLE ONLY public.form_value_tbl
    ADD CONSTRAINT fkcnqt47kst3puua4lgjjfpy24r FOREIGN KEY (form_id) REFERENCES public.form_tbl(form_id);
 T   ALTER TABLE ONLY public.form_value_tbl DROP CONSTRAINT fkcnqt47kst3puua4lgjjfpy24r;
       public          postgres    false    203    209    2902            l           2606    24038 0   form_value_image_tbl fkj8wuv2b3joxttqfvscre32vfi    FK CONSTRAINT     �   ALTER TABLE ONLY public.form_value_image_tbl
    ADD CONSTRAINT fkj8wuv2b3joxttqfvscre32vfi FOREIGN KEY (form_value_id) REFERENCES public.form_value_tbl(form_value_id);
 Z   ALTER TABLE ONLY public.form_value_image_tbl DROP CONSTRAINT fkj8wuv2b3joxttqfvscre32vfi;
       public          postgres    false    209    2908    207            n           2606    24048 )   user_role_tbl fkpfkvhcexxtyx8f6mceq5sjds4    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_role_tbl
    ADD CONSTRAINT fkpfkvhcexxtyx8f6mceq5sjds4 FOREIGN KEY (role_id) REFERENCES public.role_tbl(role_id);
 S   ALTER TABLE ONLY public.user_role_tbl DROP CONSTRAINT fkpfkvhcexxtyx8f6mceq5sjds4;
       public          postgres    false    212    2910    211            j           2606    24028 0   form_value_detail_tbl fkqgos2jjnqvixu59qs4t3vyd6    FK CONSTRAINT     �   ALTER TABLE ONLY public.form_value_detail_tbl
    ADD CONSTRAINT fkqgos2jjnqvixu59qs4t3vyd6 FOREIGN KEY (form_detail_id) REFERENCES public.form_detail_tbl(form_detail_id);
 Z   ALTER TABLE ONLY public.form_value_detail_tbl DROP CONSTRAINT fkqgos2jjnqvixu59qs4t3vyd6;
       public          postgres    false    2900    201    205            �   ;   x�3�,M�+�,��4�4�2�H,.NM�4r�9CRs��F\&���@Q#�=... �+h      �      x�3�L�/�5�2ӆ\1z\\\ =}�      �   Q   x�=ͻ�0���n��a	&H�	�_S��w���Ƹ��m��c��(t����6�Y�-坢����7����       �   N   x��Q
�  �ow�gl�w�$4�(6j޿��[�����[���6���;�Ty�0#!M�V"a�3G�L�_z:���boa      �   X   x�]���0��]�0�]|QK��#|�H~�4(PX�ݍ�f�!F/VyN8e�L�ˈ���H�ͦ�;�N����&T��۲u�s�����      �       x�3�tt����tL���S(��I����� Of      �      x�3�4����� ]          V   x�3�,�LL����T1JT14P�+���p�v7t36tL�3�1r6Ku�)pM�
24rN���O	�rwqs3q.r��(7������ ��     