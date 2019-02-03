import axios from 'axios'
import Vue from 'vue'

const Api = {

  install(Vue) {
    let apiURL = Vue.prototype.$apiURL

    Vue.prototype.$api = async function (uri, options = {}) {
      try {
        let response = await axios({
          method: options.method || 'get',
          url: options.noAPI ? uri : apiURL + uri,
          responseType: options.responseType,
          data: options.body,
          params: options.params,
          headers: {'X-Requested-With': 'XMLHttpRequest'},
          withCredentials: true,
          onUploadProgress: options.progress,
          cancelToken: options.source && options.source.token
        });
        return [response.data || {}, response]
      } catch (e) {
        console.error(e);
        return [undefined, e.response]
      }
    };

    Vue.prototype.$api.post = async function (uri, options = {}) {
      options.method = 'post';
      return await Vue.prototype.$api(uri, options)
    };

    Vue.prototype.$api.get = async function (uri, options = {}) {
      options.method = 'get';
      return await Vue.prototype.$api(uri, options)
    };

    Vue.prototype.$api.patch = async function (uri, options = {}) {
      options.method = 'patch';
      return await Vue.prototype.$api(uri, options)
    };

    Vue.prototype.$api.delete = async function (uri, options = {}) {
      options.method = 'delete';
      return await Vue.prototype.$api(uri, options)
    };

    Vue.prototype.$api.put = async function (uri, options = {}) {
      options.method = 'put';
      return await Vue.prototype.$api(uri, options)
    };

    Vue.$api = Vue.prototype.$api
  }
};

Vue.use(Api);
