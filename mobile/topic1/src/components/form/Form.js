import React, {useEffect, useState} from 'react';
import {Text, Image, TouchableOpacity, View, ScrollView} from 'react-native';
import {Checkbox, NativeBaseProvider} from 'native-base';
import NumericInput from 'react-native-numeric-input';
import Styles from './Form.style';
import {addForm, uploadFile} from '../../actions';
import {launchCamera} from 'react-native-image-picker';

const Form = (props) => {
  const [formScan, setFormScan] = useState([]);

  const [number, setNumber] = useState([]);

  const [checked, setChecked] = useState([]);

  const [images, setImage] = useState([]);

  useEffect(() => {
    const {navigation} = props;
    const data = navigation.state.params.data;
    setFormScan(data);
  }, []);

  const updateValueNumber = (key, value) => {
    let newValue = number;
    newValue[key] = value;
    setNumber(newValue);
  };

  const updateValueChecked = (key, value) => {
    let newValue = checked;
    newValue[key] = value;
    setChecked(newValue);
  };

  const sendFileImage = (formValueDetailDTOs) => {
    let formData = new FormData();
    const formBody = {};
    formBody.formId = formScan[0].formId;
    formBody.formValueDetailDTOs = formValueDetailDTOs;

    if (images.length > 0) {
      images.forEach((image, index) => {
        const file = {
          uri: image.uri,
          name: image.fileName,
          type: image.type,
        };
        formData.append('file', file);
      });

      uploadFile(formData).then((res) => {
        const formValueImages = res.data;
        const formValueImageDTOs = formValueImages.map((el, index) => ({
          formValueImageId: el.formValueImageId,
        }));
        formBody.formValueImageDTOs = formValueImageDTOs;

        addFormValue(formBody);
      });
    } else {
      addFormValue(formBody);
    }
  };

  const onSubmit = () => {
    let formValueDetailDTOs = formScan.map((el, index) => ({
      formDetailId: el.formDetailId,
      valueNum: el.fieldType === 'Number' ? number[index] : undefined,
      valueBool: el.fieldType === 'Boolean' ? checked[index] : undefined,
    }));
    formValueDetailDTOs.forEach((el, index) => {
      if (el.valueNum === undefined) {
        delete el.valueNum;
      } else if (el.valueBool === undefined) {
        delete el.valueBool;
      }
    });

    console.log(formValueDetailDTOs);

    sendFileImage(formValueDetailDTOs);
  };

  const addFormValue = (formBody) => {
    addForm(formBody)
      .then((res) => {
        const {navigation} = props;
        if (res.status === 200) {
          navigation.navigate('Welcome');
        }
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const getImageAfterOpenCamera = (image) => {
    setImage([...images, image.assets[0]]);
  };

  const onOpenCamera = () => {
    launchCamera({}, getImageAfterOpenCamera);
  };
  const renderForm = () => {
    return formScan.map((el, key) => {
      return (
        <View style={Styles.content} key={key}>
          {el.fieldType === 'Boolean' && (
            <View style={Styles.fieldContent}>
              <Text style={Styles.checkboxLabel}>{el.fieldName}</Text>
              <NativeBaseProvider>
                <Checkbox
                  value={checked[key]}
                  onChange={(value) => updateValueChecked(key, value)}
                />
              </NativeBaseProvider>
            </View>
          )}
          {el.fieldType === 'Number' && (
            <View style={Styles.fieldContent}>
              <Text style={Styles.label}>{el.fieldName}</Text>
              <View style={Styles.textInput}>
                <NumericInput
                  value={number[key]}
                  onChange={(value) => updateValueNumber(key, value)}
                />
              </View>
            </View>
          )}
        </View>
      );
    });
  };

  const renderImages = () => {
    return images.map((image, index) => {
      return <Image style={Styles.photo} source={{uri: image.uri}} />;
    });
  };

  const renderImageControl = () => {
    return (
      <View style={Styles.sectionContainer}>
        <Text style={Styles.label}>Select images</Text>
        <ScrollView style={Styles.photoList} horizontal={true}>
          {renderImages()}
          <TouchableOpacity onPress={() => onOpenCamera()}>
            <View style={[Styles.addButton, Styles.photo]}>
              <Text style={Styles.addButtonText}>+</Text>
            </View>
          </TouchableOpacity>
        </ScrollView>
      </View>
    );
  };

  return (
    <View style={Styles.container}>
      {renderForm()}
      {renderImageControl()}

      <View style={Styles.action}>
        <TouchableOpacity
          style={Styles.buttonContainer}
          onPress={() => onSubmit()}>
          <Text style={Styles.addText}>Create</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
};
export default Form;
