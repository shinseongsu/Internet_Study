type Heroes = 'Hulk' | 'Thor' | 'Capt';
type HeroAges = { [K in Heroes]: number };
const ages: HeroAges = {
  Hulk: 123,
};
