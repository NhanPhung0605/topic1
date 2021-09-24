import Colors from 'react-native/Libraries/NewAppScreen/components/Colors';

const {Platform} = require('react-native');
import {StyleSheet} from 'react-native';
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    marginTop: 50,
  },
  content: {},
  fieldContent: {
    padding: 10,
    flexDirection: 'row',
  },
  header: {
    flex: 1,
    justifyContent: 'flex-end',
    paddingHorizontal: 20,
    paddingBottom: 50,
  },
  footer: {
    flex: Platform.OS === 'ios' ? 3 : 5,
    backgroundColor: '#fff',
    borderTopLeftRadius: 30,
    borderTopRightRadius: 30,
    paddingHorizontal: 20,
    paddingVertical: 30,
  },
  text_header: {
    color: '#fff',
    fontWeight: 'bold',
    fontSize: 30,
  },
  label: {
    color: '#05375a',
    fontSize: 18,
    paddingTop: 5,
  },
  action: {
    flexDirection: 'row',
    justifyContent: 'center',
  },
  imageArea: {
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
  },
  image: {
    marginBottom: 10,
    width: 100,
    height: 100,
    borderWidth: 1,
    borderColor: 'black',
  },
  buttonContainer: {
    height: 45,
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 20,
    width: 250,
    borderRadius: 30,
    backgroundColor: '#00b5ec',
  },
  textInput: {
    paddingLeft: 10,
  },
  checkboxLabel: {
    color: '#05375a',
    fontSize: 18,
    paddingRight: 10,
  },
  button: {
    alignItems: 'center',
    marginTop: 50,
  },
  signIn: {
    width: '100%',
    height: 50,
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius: 10,
  },
  textSign: {
    fontSize: 18,
    fontWeight: 'bold',
  },
  textPrivate: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    marginTop: 20,
  },
  color_textPrivate: {
    color: 'grey',
  },
  addText: {
    color: 'white',
  },
  sectionContainer: {
    marginTop: 10,
    paddingHorizontal: 24,
  },
  photoList: {
    height: 70,
    marginTop: 15,
    marginBottom: 15,
    marginRight: 10,
  },
  photo: {
    marginRight: 10,
    width: 70,
    height: 70,
    borderRadius: 10,
  },
  addButton: {
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#3399cc',
  },
  addButtonText: {
    color: Colors.white,
    fontWeight: 'bold',
    fontSize: 48,
  },
});
export default styles;
